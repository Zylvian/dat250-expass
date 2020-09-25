package no.hvl.dat110.rest.counters;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

/**
 * Todo app.
 *
 */
public class TodoApp {
	
	static List<ToDo> todos;
	
	public static void main(String[] args) {

		if (args.length > 0) {
			port(Integer.parseInt(args[0]));
		} else {
			port(8080);
		}

		todos = new ArrayList<ToDo>();
		
		after((req, res) -> {
  		  res.type("application/json");
  		});

		// Test
		get("/hello", (req, res) -> "Hello World!");

		// Get single todo.
		get("/todo/:id", (req, res) -> {

			Long id = Long.valueOf(req.queryParams(":id"));
			//Long id = Long.valueOf(req.params(":id"));
			System.out.println(id);
			//Long id = req.params(":id");
			for(ToDo todo : todos ){
				if(id == todo.getId()){
					return todo.toJson();
				}
			}
			return String.format("{\"error\": \"TODO WITH ID %d DOESN'T EXIT\"}",id);
		});

		// Get all todos
		get("/todo", (req, res) -> {

			String[] ids_strs = req.queryParamsValues("id");

			if(ids_strs != null) {

				List<Long> ids = new ArrayList<>();
				for (String id : ids_strs)
					ids.add(Long.valueOf(id));

				List<String> jsonList = new ArrayList<String>();
				for(Long id : ids){
					for(ToDo todo : todos ){
						if (id == todo.getId()) {
							jsonList.add(todo.toJson());
						}

					}
				}
				if(jsonList.isEmpty())
					return String.format("{\"error\": \"NO TODOS WITH SPECIFIED ID(S) EXIST\"}");
				else
					return jsonList;
			}
			// Else return all todos.
			else{
				List<String> jsonList = new ArrayList<String>();
				for(ToDo todo : todos ){
					jsonList.add(todo.toJson());
				}
				return jsonList;
			}
		});

		// Make new todo.
		post("/todo",((req, res) -> {

			Gson gson = new Gson();

			ToDo newDo = gson.fromJson(req.body(), ToDo.class);

			todos.add(newDo);

			return newDo.toJson();
		}));

		// Edit an existing todo.
        put("/todo", (req,res) -> {
        
        	Gson gson = new Gson();

        	ToDo getDo = gson.fromJson(req.body(), ToDo.class);

        	Long id = getDo.getId();

			for (int i = 0; i<todos.size(); i++){
				ToDo todo = todos.get(i);
				if (todo.getId() == id){

					todos.set(i, getDo);
					return String.format("{\"success\": \"TODO WITH ID %d EDITED\"}",id);

				}
			}

            return String.format("{\"error\": \"TODO WITH ID %d DOESN'T EXIT\"}",id);
        	
        });

        // Delete todo.
        delete("/todo", (req,res) -> {

			Gson gson = new Gson();

			ToDo getDo = gson.fromJson(req.body(), ToDo.class);

			Long id = getDo.getId();

			for (int i = 0; i<todos.size(); i++){
				ToDo todo = todos.get(i);
				if (todo.getId() == id){

					todos.remove(i);
					return String.format("{\"success\": \"TODO WITH ID %d DELETED\"}",id);
				}
			}

			return String.format("{\"error\": \"TODO WITH ID %d DOESN'T EXIT\"}",id);

		});
    }

    /*public ToDo getTodo(Long id){
		for (ToDo todo : todos ){
			if (todo.getId() == id){
				return todo;
			}
		}
		return null;
	}*/
    
}
