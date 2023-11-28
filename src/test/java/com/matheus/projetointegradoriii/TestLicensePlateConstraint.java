package com.matheus.projetointegradoriii;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class TestLicensePlateConstraint {

    @Test
    void test() {
        String plate = "BRA2AAA";

        Pattern pattern = Pattern.compile("^[A-Z]{3}\\d{1}[A-Z]{1}\\d{2}$");
        Matcher matcher = pattern.matcher(plate);

        assertTrue(matcher.matches());
    }
}
