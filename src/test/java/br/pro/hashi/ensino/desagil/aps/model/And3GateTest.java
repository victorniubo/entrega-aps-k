package br.pro.hashi.ensino.desagil.aps.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class And3GateTest {
    @Test
    public void whenReceivingFalseFalseFalseShouldReturnFalse() {
        And3Gate gate = new And3Gate();
        gate.connect(0, new EmitterFalse());
        gate.connect(1, new EmitterFalse());
        gate.connect(2, new EmitterFalse());
        Assertions.assertFalse(gate.read());
    }

    @Test
    public void whenReceivingFalseFalseTrueShouldReturnFalse() {
        And3Gate gate = new And3Gate();
        gate.connect(0, new EmitterFalse());
        gate.connect(1, new EmitterFalse());
        gate.connect(2, new EmitterTrue());
        Assertions.assertFalse(gate.read());
    }

    @Test
    public void whenReceivingFalseTrueFalseShouldReturnFalse() {
        And3Gate gate = new And3Gate();
        gate.connect(0, new EmitterFalse());
        gate.connect(1, new EmitterTrue());
        gate.connect(2, new EmitterFalse());
        Assertions.assertFalse(gate.read());
    }

    @Test
    public void whenReceivingFalseTrueTrueShouldReturnFalse() {
        And3Gate gate = new And3Gate();
        gate.connect(0, new EmitterFalse());
        gate.connect(1, new EmitterTrue());
        gate.connect(2, new EmitterTrue());
        Assertions.assertFalse(gate.read());
    }

    @Test
    public void whenReceivingTrueFalseFalseShouldReturnFalse() {
        And3Gate gate = new And3Gate();
        gate.connect(0, new EmitterTrue());
        gate.connect(1, new EmitterFalse());
        gate.connect(2, new EmitterFalse());
        Assertions.assertFalse(gate.read());
    }

    @Test
    public void whenReceivingTrueFalseTrueShouldReturnFalse() {
        And3Gate gate = new And3Gate();
        gate.connect(0, new EmitterTrue());
        gate.connect(1, new EmitterFalse());
        gate.connect(2, new EmitterTrue());
        Assertions.assertFalse(gate.read());
    }

    @Test
    public void whenReceivingTrueTrueFalseShouldReturnFalse() {
        And3Gate gate = new And3Gate();
        gate.connect(0, new EmitterTrue());
        gate.connect(1, new EmitterTrue());
        gate.connect(2, new EmitterFalse());
        Assertions.assertFalse(gate.read());
    }

    @Test
    public void whenReceivingTrueTrueTrueShouldReturnTrue() {
        And3Gate gate = new And3Gate();
        gate.connect(0, new EmitterTrue());
        gate.connect(1, new EmitterTrue());
        gate.connect(2, new EmitterTrue());
        Assertions.assertTrue(gate.read());
    }
}
