package com.driver;

public class CurrentAccount extends BankAccount {
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        if (balance < getMinBalance()) throw new Exception("Insufficient Balance");
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount() {
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

//        int size = tradeLicenseId.length();
//        //Checking
//        if (size <= 1) return;
//        for (int k = 1; k < size; k++) {
//            if (tradeLicenseId.charAt(k - 1) == tradeLicenseId.charAt(k)) {
//                break;
//            }
//            if (k == size - 1) return;
//        }
//
//        Map<Character, Integer> hm = new HashMap<>();
//        for (char c : tradeLicenseId.toCharArray()) {
//            hm.put(c, hm.getOrDefault(c, 0) + 1);
//        }
//        LinkedList<Pair> ll = new LinkedList<>();
//
//        for (Character c : hm.keySet()) {
//            if (hm.get(c) > (int) Math.ceil((double) size / 2)) {
//                throw new Exception("Valid License can not be generated");
//            }
//            ll.add(new Pair(c, hm.get(c)));
//        }
//
//        ll.sort(Comparator.reverseOrder());
//
//        StringBuilder ans = new StringBuilder();
//        boolean isFront = true;
//        while (!ll.isEmpty()) {
//            char tmp;
//            if (isFront) {
//                Pair p = ll.pollFirst();
//                p.freq -= 1;
//                tmp = p.c;
//                if (p.freq != 0)
//                    ll.addFirst(p);
//            } else {
//                Pair p = ll.pollLast();
//                p.freq -= 1;
//                tmp = p.c;
//                if (p.freq != 0)
//                    ll.addLast(p);
//            }
//            ans.append(tmp);
//            isFront = !isFront;
//        }
//        tradeLicenseId = ans.toString();

        char[] charArray = this.tradeLicenseId.toCharArray();
        int i = 0;
        int j = i + 1;

        while (i < charArray.length - 1 && j < charArray.length) {
            if (charArray[i] != charArray[j]) {
                i++;
                j++;
            } else {
                while (charArray[i] == charArray[j]) {
                    j++;
                    if (j >= charArray.length) throw new Exception("Valid License can not be generated");

                }

                char temp = charArray[i + 1];
                charArray[i + 1] = charArray[j];
                charArray[j] = temp;
                i++;
                j = i + 1;
            }
        }

        String str = new String(charArray);
        this.tradeLicenseId = str;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    class Pair implements Comparable<Pair> {
        Character c;
        int freq;

        public Pair(Character c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        public int compareTo(Pair o) {
            return this.freq - o.freq;
        }
    }

}
