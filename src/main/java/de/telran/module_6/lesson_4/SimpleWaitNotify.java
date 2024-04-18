package de.telran.module_6.lesson_4;

public class SimpleWaitNotify {
    public static void main(String[] args) {
        ThreadInteraction interaction = new ThreadInteraction();

        Pilot request = new Pilot(interaction);
        Controller response = new Controller(interaction);

    }
}

class ThreadInteraction {
    boolean isActive = false;
    public synchronized void Request(String request){
        if(isActive){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Пилот:");
        System.out.println(request);
        isActive = true;
        notify();
    }

    public synchronized void Response(String response){
        if(!isActive){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Диспетчер:");
        System.out.println(response);
        isActive = false;
        notify();
    }
}

class Pilot implements Runnable {
    ThreadInteraction interaction;
    String[] request =
            {
                    "1. Dnipro Radar, Я борт - Aeroflot 1816",
                    "2. Запрос высоты, Aeroflot 1816",
                    "3. Вас понял, моя высота 6,000 фут, борт - Aeroflot 1816",
                    "4. Dnipro Radar, вас понял, подымаюсь на высоту 7,000 футов, борт - Aeroflot 1816",
                    "5. Dnipro Radar, я на высоте 7,000 футов, борт - Aeroflot 1816"
            };

    public Pilot(ThreadInteraction interaction) {
        this.interaction = interaction;
        new Thread(this, "Request").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < request.length; i++) {
            interaction.Request(request[i]);
        }
    }
}

class Controller implements Runnable {
    ThreadInteraction interaction;
    String[] response =
            {
                    "1. Aeroflot 1816, Dnipro Radar, подымитесь выше",
                    "2. Aeroflot 1816, вы на высоте 6,000 футов",
                    "3. Aeroflot 1816, вам стоит подняться на высоту 7,000 футов",
                    "4. Aeroflot 1816, когда будете на высоте 7,000 футов, доложите",
                    "5. Aeroflot 1816, принято, конец связи, удачного полета!"
            };

    public Controller(ThreadInteraction interaction) {
        this.interaction = interaction;
        new Thread(this, "Response").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < response.length; i++) {
            interaction.Response(response[i]);
        }
    }
}