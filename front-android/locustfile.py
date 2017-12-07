from locust import HttpLocust, TaskSet, task

class WebsiteTasks(TaskSet):
#    def on_start(self):
       # self.client.post("/login", {
#            "username": "test_user",
#            "password": ""
#        })
    
    @task
    def getaccountsbyid(self):
        self.client.get("/account/getaccountsbyid/1")
        

class WebsiteUser(HttpLocust):
    task_set = WebsiteTasks
    min_wait = 5000
    max_wait = 15000
