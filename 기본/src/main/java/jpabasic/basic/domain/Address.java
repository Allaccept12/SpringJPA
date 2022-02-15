package jpabasic.basic.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED )
public class Address {
    @Column(length = 10)
    private String city;

    @Column(length = 30)
    private String street;

    @Column(length = 5)
    private String zipcode;

    @Builder
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String fullAddress() {
        return getCity() + " " + getStreet() +" " + getZipcode();
    }

    public boolean isValid() {
        //필드에 값이 다있냐 없냐 등 객체 지향적인 사용 가능
        if (getCity().isEmpty() || getStreet().isEmpty() || getZipcode().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getZipcode(), address.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
