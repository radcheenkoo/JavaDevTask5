package org.example.modelsForDatabaseQueryService;

public class LongestProject {
        private String id;
        private String amountOfMonths;

        public LongestProject(String id, String amountOfMonths) {
            this.id = id;
            this.amountOfMonths = amountOfMonths;
        }

        public String getId() {
            return id;
        }

        public String getAmountOfMonths() {
            return amountOfMonths;
        }
}
