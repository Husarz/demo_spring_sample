/*
 * This file is generated by jOOQ.
*/
package co.aisystem.demo.api.db.users;


import co.aisystem.demo.api.db.users.tables.Address;
import co.aisystem.demo.api.db.users.tables.Person;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>public</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index ADDRESS_PKEY = Indexes0.ADDRESS_PKEY;
    public static final Index PERSON_PKEY = Indexes0.PERSON_PKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index ADDRESS_PKEY = Internal.createIndex("address_pkey", Address.ADDRESS, new OrderField[] { Address.ADDRESS.ID }, true);
        public static Index PERSON_PKEY = Internal.createIndex("person_pkey", Person.PERSON, new OrderField[] { Person.PERSON.ID }, true);
    }
}
