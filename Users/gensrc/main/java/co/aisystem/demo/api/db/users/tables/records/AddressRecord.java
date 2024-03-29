/*
 * This file is generated by jOOQ.
*/
package co.aisystem.demo.api.db.users.tables.records;


import co.aisystem.demo.api.db.users.tables.Address;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AddressRecord extends UpdatableRecordImpl<AddressRecord> implements Record10<Long, Long, String, String, String, String, String, String, String, String> {

    private static final long serialVersionUID = 219885941;

    /**
     * Setter for <code>public.address.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.address.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.address.person_id</code>.
     */
    public void setPersonId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.address.person_id</code>.
     */
    public Long getPersonId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.address.street</code>.
     */
    public void setStreet(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.address.street</code>.
     */
    public String getStreet() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.address.house_number</code>.
     */
    public void setHouseNumber(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.address.house_number</code>.
     */
    public String getHouseNumber() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.address.flat_number</code>.
     */
    public void setFlatNumber(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.address.flat_number</code>.
     */
    public String getFlatNumber() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.address.city</code>.
     */
    public void setCity(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.address.city</code>.
     */
    public String getCity() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.address.postal_code</code>.
     */
    public void setPostalCode(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.address.postal_code</code>.
     */
    public String getPostalCode() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.address.country</code>.
     */
    public void setCountry(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.address.country</code>.
     */
    public String getCountry() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.address.region</code>.
     */
    public void setRegion(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.address.region</code>.
     */
    public String getRegion() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.address.type</code>.
     */
    public void setType(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.address.type</code>.
     */
    public String getType() {
        return (String) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<Long, Long, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<Long, Long, String, String, String, String, String, String, String, String> valuesRow() {
        return (Row10) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Address.ADDRESS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return Address.ADDRESS.PERSON_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Address.ADDRESS.STREET;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Address.ADDRESS.HOUSE_NUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Address.ADDRESS.FLAT_NUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Address.ADDRESS.CITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Address.ADDRESS.POSTAL_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Address.ADDRESS.COUNTRY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Address.ADDRESS.REGION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return Address.ADDRESS.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getPersonId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getStreet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getHouseNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getFlatNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getCity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getPostalCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getCountry();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getRegion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getPersonId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getStreet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getHouseNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getFlatNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getCity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getPostalCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getCountry();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getRegion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value2(Long value) {
        setPersonId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value3(String value) {
        setStreet(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value4(String value) {
        setHouseNumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value5(String value) {
        setFlatNumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value6(String value) {
        setCity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value7(String value) {
        setPostalCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value8(String value) {
        setCountry(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value9(String value) {
        setRegion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord value10(String value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressRecord values(Long value1, Long value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AddressRecord
     */
    public AddressRecord() {
        super(Address.ADDRESS);
    }

    /**
     * Create a detached, initialised AddressRecord
     */
    public AddressRecord(Long id, Long personId, String street, String houseNumber, String flatNumber, String city, String postalCode, String country, String region, String type) {
        super(Address.ADDRESS);

        set(0, id);
        set(1, personId);
        set(2, street);
        set(3, houseNumber);
        set(4, flatNumber);
        set(5, city);
        set(6, postalCode);
        set(7, country);
        set(8, region);
        set(9, type);
    }
}
