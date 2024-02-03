package com.kafka.learning.kafka3satfeb2024;

import com.kafka.learning.kafka3satfeb2024.service.KafkaProducerService;
import com.kafka.learning.kafka3satfeb2024.service.datagenerator.InvoiceGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Kafka3SatFeb2024Application implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(Kafka3SatFeb2024Application.class, args);
	}
	private final KafkaProducerService producerService;

	private final InvoiceGenerator invoiceGenerator;

	@Value("${application.configs.invoice.count}")
	private int INVOICE_COUNT;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		for (int i = 0; i < INVOICE_COUNT; i++) {
			producerService.sendMessage(invoiceGenerator.getNextInvoice());
			Thread.sleep(1000);
		}
	}
}
