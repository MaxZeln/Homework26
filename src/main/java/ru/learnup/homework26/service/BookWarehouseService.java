package ru.learnup.homework26.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import ru.learnup.homework26.dao.SpringDataBook_WarehouseDao;
import ru.learnup.homework26.entity.Book_Warehouse;
import ru.learnup.homework26.exeption.NotEnoughItems;
import ru.learnup.homework26.repository.Book_WarehouseRepository;

import javax.persistence.EntityNotFoundException;

@Service
@Slf4j
public class BookWarehouseService {

    private final SpringDataBook_WarehouseDao WareHouseDao;
    private final TransactionTemplate transactionTemplate;
    private final Book_WarehouseRepository repository;


    public BookWarehouseService(SpringDataBook_WarehouseDao wareHouseDao,
                                TransactionTemplate transactionTemplate,
                                Book_WarehouseRepository repository) {
        this.WareHouseDao = wareHouseDao;
        this.transactionTemplate = transactionTemplate;
        this.repository = repository;
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.SERIALIZABLE,
            timeout = 3,
            readOnly = false,
            rollbackFor = {RuntimeException.class},
            noRollbackFor = {IllegalArgumentException.class}
    )
    public synchronized void transactionBuyABook(int id) {
        Book_Warehouse book_warehouse = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

//        book_warehouse.setBooks_amount(1);

        try {
            if (book_warehouse.getBooks_amount() <= 0) {
                throw new NotEnoughItems("данная книга была куплена другим пользователем");
            }

            System.out.print("\nКнига: ");
            System.out.println(book_warehouse.getBook().getTitle());
            System.out.print("колличество на складе: ");
            System.out.println(book_warehouse.getBooks_amount());

            int amount = book_warehouse.getBooks_amount() - 1;
            book_warehouse.setBooks_amount(amount);

            System.out.println("\nТовар успешно преобретён, спасибо за покупку!");

        } catch (NotEnoughItems e) {
            System.out.println(book_warehouse.getBooks_amount());
            System.out.println(e);
        }
    }
}
