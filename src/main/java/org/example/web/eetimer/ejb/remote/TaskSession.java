package org.example.web.eetimer.ejb.remote;

import jakarta.ejb.Local;

import java.util.concurrent.Future;

@Local
public interface TaskSession {
    Future<String> doTask();
}
