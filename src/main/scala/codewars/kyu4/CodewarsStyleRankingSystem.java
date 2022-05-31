package codewars.kyu4;

/**
 * 2022-05-31
 * {@see <a href='https://www.codewars.com/kata/51fda2d95d6efda45e00004e/train/scala'/> }
 */
public class CodewarsStyleRankingSystem {
    static class User {
        private int[] rankArr = new int[]{-8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8};
        private int pos = 0;
        public int rank = this.rankArr[this.pos];
        public int progress = 0;

        public void incProgress(int rank) {
            if (rank < -8 || rank == 0 || rank > 8) {
                throw new IllegalArgumentException();
            }
            int newPos = rank < 0 ? rank + 8 : rank + 7; //新rank的下标
            int posSpan = newPos - this.pos;
            if (posSpan == 0) {
                this.progress += 3;
            } else if (posSpan == -1) {
                this.progress += 1;
            } else if (posSpan > 0) {
                this.progress += posSpan * posSpan * 10;
            }
            double rankUp = Math.floor(this.progress / 100.0);
            this.progress -= rankUp * 100;
            this.pos += rankUp;
            this.rank = this.rankArr[this.pos];
            this.progress = this.rank == 8 ? 0 : this.progress;
        }
    }
}
