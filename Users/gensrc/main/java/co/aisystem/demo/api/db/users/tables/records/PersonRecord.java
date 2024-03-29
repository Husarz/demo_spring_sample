/*
 * This file is generated by jOOQ.
*/
package co.aisystem.demo.api.db.users.tables.records;


import co.aisystem.demo.api.db.users.tables.Person;

import java.time.OffsetDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PersonRecord extends UpdatableRecordImpl<PersonRecord> implements Record7<Long, String, String, OffsetDateTime, String, Boolean, String> {

    private static final long serialVersionUID = 1567537856;

    /**
     * Setter for <code>public.person.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.person.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.person.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.person.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.person.surname</code>.
     */
    public void setSurname(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.person.surname</code>.
     */
    public String getSurname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.person.date</code>.
     */
    public void setDate(OffsetDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.person.date</code>.
     */
    public OffsetDateTime getDate() {
        return (OffsetDateTime) get(3);
    }

    /**
     * Setter for <code>public.person.status</code>.
     */
    public void setStatus(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.person.status</code>.
     */
    public String getStatus() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.person.first_visit</code>.
     */
    public void setFirstVisit(Boolean value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.person.first_visit</code>.
     */
    public Boolean getFirstVisit() {
        return (Boolean) get(5);
    }

    /**
     * Setter for <code>public.person.nip</code>.
     */
    public void setNip(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.person.nip</code>.
     */
    public String getNip() {
        return (String) get(6);
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
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Long, String, String, OffsetDateTime, String, Boolean, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Long, String, String, OffsetDateTime, String, Boolean, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Person.PERSON.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Person.PERSON.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Person.PERSON.SURNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<OffsetDateTime> field4() {
        return Person.PERSON.DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Person.PERSON.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field6() {
        return Person.PERSON.FIRST_VISIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Person.PERSON.NIP;
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
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getSurname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffsetDateTime component4() {
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component6() {
        return getFirstVisit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getNip();
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
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getSurname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffsetDateTime value4() {
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value6() {
        return getFirstVisit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getNip();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value3(String value) {
        setSurname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value4(OffsetDateTime value) {
        setDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value5(String value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value6(Boolean value) {
        setFirstVisit(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord value7(String value) {
        setNip(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonRecord values(Long value1, String value2, String value3, OffsetDateTime value4, String value5, Boolean value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PersonRecord
     */
    public PersonRecord() {
        super(Person.PERSON);
    }

    /**
     * Create a detached, initialised PersonRecord
     */
    public PersonRecord(Long id, String name, String surname, OffsetDateTime date, String status, Boolean firstVisit, String nip) {
        super(Person.PERSON);

        set(0, id);
        set(1, name);
        set(2, surname);
        set(3, date);
        set(4, status);
        set(5, firstVisit);
        set(6, nip);
    }
}
