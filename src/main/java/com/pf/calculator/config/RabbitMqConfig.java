package com.pf.calculator.config;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:rabbitmq-config.xml"})
public class RabbitMqConfig {

	@Bean
	public ConnectionFactory connectionFactory() {
		URI rabbitMqUrl;
		CachingConnectionFactory factory = new CachingConnectionFactory();
		try {
			rabbitMqUrl = new URI(System.getenv("RABBITMQ_BIGWIG_URL"));
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
		
		factory.setUsername(rabbitMqUrl.getUserInfo().split(":")[0]);
		factory.setPassword(rabbitMqUrl.getUserInfo().split(":")[1]);
		factory.setHost(rabbitMqUrl.getHost());
		factory.setPort(rabbitMqUrl.getPort());
		factory.setVirtualHost(rabbitMqUrl.getPath().substring(1));
		
		return factory;
	}
}
