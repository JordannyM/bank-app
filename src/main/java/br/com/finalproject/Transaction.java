package br.com.finalproject;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
@NoArgsConstructor

public class Transaction {
    private String dateAndTime;
    private String id;
    private String bank;
    private String agency;
    private String number;
    private String operator;
    private String type;
    private String value;

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Transaction)) {
            return false;
        }

        Transaction transaction = (Transaction) o;

        return new EqualsBuilder()
                .append(dateAndTime, transaction.dateAndTime)
                .append(id, transaction.id)
                .append(bank, transaction.bank)
                .append(agency, transaction.agency)
                .append(number, transaction.number)
                .append(operator, transaction.operator)
                .append(type, transaction.type)
                .append(value, transaction.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(dateAndTime)
                .append(id)
                .append(bank)
                .append(agency)
                .append(number)
                .append(operator)
                .append(type)
                .append(value)
                .toHashCode();
    }
}
