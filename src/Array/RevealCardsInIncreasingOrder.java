package Array;

import java.util.Arrays;
import java.util.LinkedList;

//题目描述:给定一个数组，进行如下操作，拿出第一个元素，然后第二个元素放到数组的末尾，使得拿出来的元素是升序排列，例如[17,13,11,2,3,5,7]，返回[2,13,3,11,5,17,7]，这样按照操作
//       可以得到一个升序排列
//解法描述:反向操作

public class RevealCardsInIncreasingOrder {

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.add(deck[deck.length - 1]);
        for (int i = deck.length - 2; i >= 0; --i) {
            list.addFirst(list.getLast());
            list.removeLast();
            list.addFirst(deck[i]);
        }

        for (int i = 0; i < deck.length; ++i) {
            deck[i] = list.get(i);
        }

        return deck;
    }
}
