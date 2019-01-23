package com.github.anmir.connection

import mu.KLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.sql.Connection

@RestController
@RequestMapping("/connections")
class ConnectionController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): List<Connection> {
        logger.info { "Returning list of Person objects" }
        return emptyList()
    }


    @GetMapping("/ds")
    @ResponseStatus(HttpStatus.OK)
    fun ds() {
        ConnectionProvider.ds()
    }


    @GetMapping("/ds/jndi")
    @ResponseStatus(HttpStatus.OK)
    fun dsJndi() {
        val ds = ConnectionProvider.getDsFromJndi()
        val connection = ds.connection
        logger.info { "connection: $connection" }
        connection.close()
        logger.info { "isClosed: ${connection.isClosed}" }
    }

    @GetMapping("/ds/jndi/pg")
    @ResponseStatus(HttpStatus.OK)
    fun dsJndiPg() {
        val ds = ConnectionProvider.getDsFromJndi2()
        val connection = ds.connection
        logger.info { "connection: $connection" }
        connection.close()
        logger.info { "isClosed: ${connection.isClosed}" }
    }

    companion object : KLogging()

}