package com.hongna.leetcode.Array;

public class Ticket implements  Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            sellTicket();
        }
    }

    public synchronized void sellTicket() {
        if (ticket > 0 ){
            try{
                Thread.sleep(100);
                ticket -- ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String name = Thread.currentThread().getName();
            System.out.println(name + "正在卖" + ticket);
        }
    }
}
