package com.demo;

import java.util.concurrent.DelayQueue;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/1/24.
 */
public class WangBa implements Runnable {

    public boolean yinye = true;
    private DelayQueue<Wangming> queue = new DelayQueue<Wangming>();

    public static void main(String args[]) {
        try {
            System.out.println("网吧开始营业");
            WangBa siyu = new WangBa();
            Thread shangwang = new Thread(siyu);
            shangwang.start();

            siyu.shangji("路人甲", "123", 1);
            siyu.shangji("路人乙", "234", 2);
            siyu.shangji("路人丙", "345", 3);
        } catch (Exception ex) {

        }

    }

    public void shangji(String name, String id, int money) {
        Wangming man = new Wangming(name, id, 1000 * 5 * money + System.currentTimeMillis());
        System.out.println("网名" + man.getName() + " 身份证" + man.getId() + "交钱" + money + "块,开始上机...");
        this.queue.add(man);
    }

    public void xiaji(Wangming man) {
        System.out.println("网名" + man.getName() + " 身份证" + man.getId() + "时间到下机...");
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (yinye) {
            try {
                System.out.println("检查ing");
                Wangming man = queue.take();
                xiaji(man);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

