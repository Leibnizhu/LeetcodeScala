package codewars.kyu4;


public class CodewarsStyleRankingSystemTest {

    public static void main(String[] args) {
        CodewarsStyleRankingSystem.User user = new CodewarsStyleRankingSystem.User();
        assert user.rank == -8; // => -8
        assert user.progress == 0; // => 0
        user.incProgress(-7);
        assert user.progress == 10; // => 10
        user.incProgress(-5); // will add 90 progress
        assert user.progress == 0; // => 0 // progress is now zero
        assert user.rank == -7; // => -7 // rank was upgraded to -7
    }

}