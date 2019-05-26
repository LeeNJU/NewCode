package BackTracking;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//题目描述:给定一些item的价格，已经需要购买的每个item的个数，还有一些special offer，求需要最少的钱，例如[2,5], [[3,0,5],[1,2,10]], [3,2]
//       有两个item，价格是2和5，需要的数量是3和2，special offer是3个item1，0个item2的价格是5
//解法描述:针对needs数组进行递归，递归每一步可以选择某一个special offer

public class ShoppingOffers {

    // 返回满足当前需要的最小价格
    private int dfs(List<Integer> prices, List<List<Integer>> special, List<Integer> needs) {
        // 不考虑special offer的价格
        int result = IntStream.range(0, needs.size())
                .map(index -> needs.get(index) * prices.get(index))
                .sum();

        for (int i = 0; i < special.size(); ++i) {
            List<Integer> offer = special.get(i);

            // 如果可以使用这个special offer
            if (IntStream.range(0, needs.size())
                    .allMatch(index -> needs.get(index) >= offer.get(index))) {

                List<Integer> list = IntStream.range(0, needs.size())
                        .map(index -> needs.get(index) - offer.get(index))
                        .boxed()
                        .collect(Collectors.toList());

                result = Math.min(result, offer.get(offer.size() - 1) + dfs(prices, special, list));
            }
        }

        return result;
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs);
    }
}
