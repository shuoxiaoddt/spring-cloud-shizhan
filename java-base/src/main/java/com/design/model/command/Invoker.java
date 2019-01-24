package com.design.model.command;

/**
 * Created by xiaos 2019/1/24
 * //TODO 写点注释吧
 */
public class Invoker {

    private Command command;

    public Invoker(Command command){
        this.command = command;
    }

    public void invoker(){
        command.execute();;
    }

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Invoker invoker = new Invoker(new GoodByeCommand(receiver));
        invoker.invoker();
    }

}
