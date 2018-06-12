package co.aisystem.demo.api.db.users.connector

import java.io.FileInputStream
import java.util.Properties

import com.zaxxer.hikari.{HikariConfig, HikariDataSource}
import org.jooq.impl.DefaultDSLContext
import org.jooq.{DSLContext, SQLDialect}

import scala.collection.JavaConverters

object DslUsers {

  private val PATH_PROPERTIES = "jooqControl/target/classes/datasource.properties"

  def connect(): DSLContext = {
    dslContext()
  }

  private def dslContext(): DSLContext = {
    val fis = new FileInputStream(PATH_PROPERTIES)
    val prop = new Properties
    prop.load(fis)
    prop.list(System.out)
    val p2 = limitOnlyDatasourceProp(prop)
    val hc = new HikariConfig(p2)

    val dataSource = new HikariDataSource(hc)
    new DefaultDSLContext(dataSource, SQLDialect.POSTGRES_9_5)
  }

  private def limitOnlyDatasourceProp(prop: Properties): Properties = {
    val prop1 = new Properties

    JavaConverters.mapAsScalaMap(prop)
      .map(tv => tv.copy(_1 = tv._1.toString))
      .filter(t => t._1.contains("datasource"))
      .map(t => t.copy(_1 = cutKeyDataSource(t._1)))
      .foreach(t => prop1.put(t._1, t._2))

    System.out.println("====after filtered====")
    prop.list(System.out)
    prop1
  }

  private def cutKeyDataSource(key: String) = key.substring("users.datasource.".length)
}
