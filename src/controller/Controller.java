package controller;

import model.Model;
import service.Service;
import util.Info;
import util.Input;
import util.Instruction;
import util.Validator;

public class Controller {

    private Input input = new Input();
    private Info info = new Info();
    private Service service = new Service();
    private Validator validator = new Validator();
    private Instruction instruction = new Instruction();

    public int getNumber() {
        info.getInfo();
        int number = input.getNumber();
        while (!validator.isPositiveNumber(number)) {
            instruction.getInstruction();
            number = new Input().getNumber();
        }
        return number;
    }

    public void numberWrite() {
        Model number =new Model(getNumber());
        info.getNumberWrite(service.getNumber(number));
        repeat();
    }

    public void repeat() {
        String exit;
        info.getRequest();
        exit = input.getAnswer();
        if (exit.equals("y") || exit.equals("yes")) {
            numberWrite();
        } else {
            System.exit(0);
        }
    }
}
