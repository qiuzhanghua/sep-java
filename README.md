# 字符流中敏感词报警

场景如下，用户通过网络给你提供一个连续不断的字符流，希望能在有敏感词出现的时候能够报警。

请实现该算法。

提示：
1. 只做核心算法，不真正处理网络事件；
2. 空格之类的分隔符不是敏感词；
3. 关键词有多个，每个最长不超多1000字符；
4. 可考虑Trie和Ring
5. Linux下./gradlew test或者Windows下gradlew test，需要通过
