package co.aisystem.demo.api.db.users

import co.aisystem.demo.api.db.users.connector.DslUsers

import co.aisystem.demo.api.db.users.Public.PUBLIC
import co.aisystem.demo.api.db.users.tables.Person.PERSON

object Runner extends App {

  println("Hello scala")

  val l = "hello" :: "world" :: Nil
  println(l)

  val dsl = DslUsers.connect()
  dsl
    .select() from PERSON fetch()
//
//  dsl.ddl(PUBLIC).queries()
}
