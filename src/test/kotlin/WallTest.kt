import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class WallTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addPostTest() {
        val post = Post(
            1,
            1,
            "author",
            "conntent",
            0,
            0,
            "text",
            true,
            0,
            1,
            Likes()
        )
        WallService.add(post)

        assertEquals(1, WallService.getPosts().size)

    }


    @Test
    fun noUpdateTestId() {

        var post = Post(1, 1, "author", "conntent", 0, 0, "text", true, 0, 1, Likes())
        val postTest = Post(2, 1, "author", "conntent", 0, 0, "text", true, 0, 1, Likes())

        WallService.add(post)
        val result = WallService.update(postTest)
        assertEquals(false, result)

    }

    @Test
    fun UpdateTestId() {

        var post = Post(    1, 1, "author", "content", 0, 0, "text", true, 0, 1, Likes())
        val postTest = Post(1, 1, "author", "content", 0, 0, "text", true, 0, 1, Likes())

        WallService.add(post)
        val result = WallService.update(postTest)
        assertEquals(true, result)

    }

}