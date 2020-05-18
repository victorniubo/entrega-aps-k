package br.pro.hashi.ensino.desagil.aps.model;

public class And3Gate extends Gate {
    private final NandGate nand0;
    private final NandGate nand1;
    private final NandGate nand2;
    private final NandGate nand3;

    public And3Gate() {
        super("AND3", 3);

        nand0 = new NandGate();
        nand1 = new NandGate();
        nand2 = new NandGate();
        nand3 = new NandGate();

        nand1.connect(0, nand0);
        nand1.connect(1, nand0);
        nand2.connect(0, nand1);
        nand3.connect(0, nand2);
        nand3.connect(1, nand2);

    }

    @Override
    public boolean read() {
        return nand3.read();
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if (inputIndex < 0 || inputIndex > 2) {
            throw new IndexOutOfBoundsException(inputIndex);
        }
        if (inputIndex == 0) {
            nand0.connect(0, emitter);
        } else if(inputIndex == 1){
            nand0.connect(1, emitter);
        } else {
            nand2.connect(1, emitter);
        }
    }
}
