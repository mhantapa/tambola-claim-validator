package com.tambola.claim.validator.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Ticket {
    private final List<Set<Integer>> ticketNumbers;

    public Ticket(List<List<Integer>> numbers) {
        this.ticketNumbers = new ArrayList<>();
        numbers.forEach(row -> {
            Set<Integer> rowSet = new HashSet<>();
            row.stream().filter(Objects::nonNull).forEach(rowSet::add);
            this.ticketNumbers.add(rowSet);
        });
    }

    public Set<Integer> getRow(int index) {
        return new HashSet<>(ticketNumbers.get(index));
    }

    public List<Set<Integer>> getTicketNumbers() {
        List<Set<Integer>> fetchNumbers = new ArrayList<>();
        ticketNumbers.forEach(row -> fetchNumbers.add(new HashSet<>(row)));
        return fetchNumbers;
    }

    public boolean isNumberPresent(int number) {
        return ticketNumbers.stream().anyMatch(row -> row.contains(number));
    }
}
