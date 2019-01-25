package com.github.anmir.connection

import mu.KLogging
import org.springframework.jndi.JndiTemplate
import java.sql.DriverManager
import javax.sql.DataSource

object ConnectionProvider : KLogging() {


    fun ds() {
        DriverManager.getConnection("jdbc:h2:tcp://localhost:1521/test", "sa", "").use {
            logger.info { "connection: $it" }
        }
    }


    fun getH2Jndi(): DataSource {
        return JndiTemplate().lookup("java:/comp/env/jdbc/h2") as DataSource
    }

    fun getPgJndi(): DataSource {
        return JndiTemplate().lookup("java:/comp/env/jdbc/pg") as DataSource
    }

}