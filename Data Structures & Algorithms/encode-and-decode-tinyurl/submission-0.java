class Solution {

    private static final String BASE_URL = "https://example.com/";
    private static final String BASE_64 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
    private static final int LENGTH = 6;
    private final Random random = new Random();
    private final Map<String, String> longToShort = new HashMap<>();
    private final Map<String, String> shortToLong = new HashMap<>();

    public String encode(String longUrl) {
        if(longToShort.containsKey(longUrl)) {
            return longToShort.get(longUrl);
        }

        String shortUrl;
        do {
            shortUrl = BASE_URL + hash();
        } while(shortToLong.containsKey(shortUrl));

        shortToLong.put(shortUrl, longUrl);
        longToShort.put(longUrl, shortUrl);

        return shortUrl;
    }

    public String decode(String shortUrl) {
        if(shortToLong.containsKey(shortUrl)) {
            return shortToLong.get(shortUrl);
        }

        return "";
    }

    private String hash() {
        StringBuilder bldr = new StringBuilder();
        for(int i=0; i < LENGTH; i++) {
            bldr.append(BASE_64.charAt(random.nextInt(0, BASE_64.length())));
        }

        return bldr.toString();
    }
}
