package ru.skillfactorydemo.tgbot.service;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.skillfactorydemo.tgbot.repository.IncomeRepository;
import ru.skillfactorydemo.tgbot.repository.SpendRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FinanceServiceTest {

    @InjectMocks
    private FinanceService financeService;

    @Mock
    private SpendRepository spendRepository;

    @Mock
    private IncomeRepository incomeRepository;

    @BeforeEach
    public void beforeEach() {
        System.out.println(System.currentTimeMillis());
    }

    @AfterEach
    public void afterEach() {
        System.out.println(System.currentTimeMillis());
    }

    @DisplayName("ADD_INCOME_test")
    @Test
    public void addFinanceOperationAddIncomeTest() {
        // установили произвольное значение переменной для отправки в метод
        String price = "150.0";
        // обращаемся к методу с произвольными параметрами и сохраняем результат в переменную
        String message = financeService.addFinanceOperation("/addincome", price, 500L);
        // убеждаемся, что получили ожидаемый результат
        Assertions.assertEquals("Доход в размере " + price + " был успешно добавлен", message);
    }

    // тестовый метод для второго кейса, всё аналогично первому, но с другими параметрами
    @DisplayName("non_ADD_INCOME_test")
    @Test
    public void addFinanceOperationElseBranchTest() {
        // снова даём значение переменной
        String price = "200";
        // снова обращаемся к методу с другими параметрами
        String message = financeService.addFinanceOperation("/nan", price, 250L);
        // убеждаемся, что получили ожидаемый результат
        Assertions.assertEquals("Расход в размере " + price + " был успешно добавлен", message);
    }
}