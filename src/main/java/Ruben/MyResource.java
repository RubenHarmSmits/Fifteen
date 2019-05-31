package Ruben;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("myresource")
public class MyResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
        Board board = new Board();
        return Response.ok().entity(board).build();
    }

    @POST
    @Path("{isSolved}")
    public Boolean isSolved(Board board) {
        boolean isSolved = board.isSolved();
        return isSolved;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSolved(Board board) {
        board.solve();
        return Response.ok().entity(board).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response Move(@QueryParam("x") int x, @QueryParam("y") int y, Board board) {
        board.move(x,y);
        return Response.ok().entity(board).build();
    }


}
