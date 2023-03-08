package com.example.Project.Entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


    @AllArgsConstructor
    @NoArgsConstructor

    @ToString
    @Entity
    @Table(name = "player")
    public class Player_Entity {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private int pid;
        private String pname;
        private String prating;
        private int page;

        public int getPid() {
            return pid;
        }
        public void setPid(int pid) {
            this.pid = pid;
        }
        public String getPname() {
            return pname;
        }
        public void setPname(String pname) {
            this.pname = pname;
        }
        public String getPrating() {
            return prating;
        }
        public void setPrating(String prating) {
            this.prating = prating;
        }
        public int getPage() {
            return page;
        }
        public void setPage(int page) {
            this.page = page;
        }

    }


