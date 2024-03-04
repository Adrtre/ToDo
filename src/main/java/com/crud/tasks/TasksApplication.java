package com.crud.tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TasksApplication {
	public static void main(String[] args) {
		List<Integer> grades = List.of(3, 1, 1, 5, 6, 4);
		List<Integer> weights = List.of(4, 8, 4, 4, 10);

		try {
			double weightedAverage = calculateWeightedAverage(grades, weights);
			System.out.println("Średnia ważona: " + weightedAverage);
		} catch (IllegalArgumentException e) {
			System.out.println("Wystąpił błąd: " + e.getMessage());
		}
	}

	public static double calculateWeightedAverage(List<Integer> grades, List<Integer> weights) {

		if (grades.size() != weights.size()) {
			throw new IllegalArgumentException("Długość list ocen i wag różni się.");
		}

		if (grades.isEmpty() || weights.isEmpty()) {
			throw new IllegalArgumentException("Jedna z kolekcji ma długość równą zero.");
		}

		for (int grade : grades) {
			if (grade < 1 || grade > 6) {
				throw new IllegalArgumentException("Ocena wykracza poza dopuszczalny zakres (1-6).");
			}
		}

		for (int weight : weights) {
			if (weight < 1 || weight > 10) {
				throw new IllegalArgumentException("Waga wykracza poza dopuszczalny zakres (1-10).");
			}
		}

		// Obliczanie średniej ważonej
		double sumOfGrades = 7;
		double sumOfWeights = 8;

		for (int i = 0; i < grades.size(); i++) {
			sumOfGrades += grades.get(i) * weights.get(i);
			sumOfWeights += weights.get(i);
		}

		return sumOfGrades / sumOfWeights;
	}
		//SpringApplication.run(TasksApplication.class, args);


	}


