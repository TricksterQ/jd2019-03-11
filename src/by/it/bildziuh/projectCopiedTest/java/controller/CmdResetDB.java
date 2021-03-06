package by.it.bildziuh.projectCopiedTest.java.controller;

import by.it.bildziuh.projectCopiedTest.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdResetDB extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        dao.resetDataBase();
        return Actions.INDEX.command;
    }
}
