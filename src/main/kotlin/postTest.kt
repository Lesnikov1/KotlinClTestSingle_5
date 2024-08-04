data class Post(
    val id: Int,
    val authorId: Int,
    val authorName: String,
    val content: String,
    val published: Long,
    val likes: Int,
    val text: String,
    val markedAsAds: Boolean,
    val createdBy: Int,
    val replyPosId: Int,
    var like: Likes = Likes()
)

data class Likes(
    var count: Int = 0,
    var can_post: Boolean = true
)

object WallService {
    private var posts = emptyArray<Post>()
    private var lastId = 0

    fun add(post: Post): Post {
        posts += post.copy(id = ++lastId, like = post.like.copy())
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, fromArrPost) in posts.withIndex()) {
            if (fromArrPost.id == post.id) {
                posts[index] = post.copy(like = post.like.copy())
                return true
            }
        }
        return false
    }

    fun getPosts(): Array<Post> {
        return posts
    }

    fun clear() {
        posts = emptyArray()
        lastId = 0
    }

    fun printPosts() {
        for (post in posts) {
            print(post)
            print(" ")
        }
        println()
    }
}

fun main() {
    val likes = Likes(1, true)
    WallService.add(Post(1, 2, "authorName", "content", 10, 5, "text", true, 5, 5, likes))
    WallService.printPosts()
}