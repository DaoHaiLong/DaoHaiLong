package P1;

public class Deal {
    public static void main(String[] args) {
        int card_per_player=5;
        int player=Integer.parseInt(args[0]);
         String[] A={"Clubs","Diamonds","Hearts","Spades"};
         String[] rank={"1","2","3","4","5","6","7","8","9","J","Q","K","AE"};
         int n=A.length * rank.length;
        if ((card_per_player * player)>n)
            throw new RuntimeException(" too many player:");

        String[] deck=new String[n];
        for (int i = 0; i < rank.length; i++) {
            for (int j = 0; j < A.length; j++) {
                deck[A.length*i + j] = rank[i] + " of " + A[j];
            }
        }

        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }

        for (int i = 0; i < player* card_per_player; i++) {
            System.out.println(deck[i]);
            if (i % card_per_player== card_per_player - 1)
                System.out.println();
        }
    }
}

