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

public class Account {
    private String id;
    private String bank;
    private String agency;
    private String number;
    private double balance;

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Account)) {
            return false;
        }

        Account account = (Account) o;

        return new EqualsBuilder()
                .append(id, account.id)
                .append(bank, account.bank)
                .append(agency, account.agency)
                .append(number, account.number)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(bank)
                .append(agency)
                .append(number)
                .toHashCode();
    }
}
