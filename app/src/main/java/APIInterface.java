import retrofit2.http.GET;

public interface APIInterface {

    @GET("https://www.mangaeden.com/api/list/0/")
    Call<Manga> getMangaList();
}
