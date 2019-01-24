package com.design.model.command;

/**
 * Created by xiaos 2019/1/24
 * //TODO 写点注释吧
 */
public class GoodByeCommand implements Command {

    private Receiver receiver;
    public GoodByeCommand(Receiver receiver){
        this.receiver = receiver;
    }

    public void execute() {
        receiver.sayGoodBye();
    }
}
