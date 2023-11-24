package nextstep.courses.domain;

import nextstep.courses.exception.IncorrectAmountException;
import nextstep.courses.exception.NotPositiveException;
import nextstep.payments.domain.Payment;

public class Amount {

    public static final long MIN_AMOUNT = 1L;
    private final long amount;

    public Amount(long amount) {
        if (isPositive(amount)) {
            throw new NotPositiveException("금액은 양수만 가능합니다.");
        }

        this.amount = amount;
    }

    private static boolean isPositive(long amount) {
        return amount < MIN_AMOUNT;
    }

    private boolean isSameAmount(Payment payment) {
        return payment.isSameAmount(amount);
    }

    public void validateAmount(Payment payment) {
        if (!isSameAmount(payment)) {
            throw new IncorrectAmountException("결제 금액과 강의 금액이 다릅니다.");
        }
    }
}