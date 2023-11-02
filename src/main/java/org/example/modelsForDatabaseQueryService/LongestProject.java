package org.example.modelsForDatabaseQueryService;

public class LongestProject {
        private int id;
        private int amountOfMonths;

        public LongestProject(int id, int amountOfMonths) {
            this.id = id;
            this.amountOfMonths = amountOfMonths;
        }

        public int getId() {
            return id;
        }

        public int getAmountOfMonths() {
            return amountOfMonths;
        }
}
