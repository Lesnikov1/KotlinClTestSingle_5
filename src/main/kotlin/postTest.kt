data class Post(
    val id: Int,
    val authorId: Int,
    val authorName: String,
    val content: String,
    val published: Long,
    val likes: Int,
    val text: String,
    val marked_as_ads: Boolean,
    val created_by: Int,
    val reply_post_id: Int,
    val like: Likes
)

class Likes(
    var count: Int = 0,
    var can_post: Boolean = true,
    var groups_can_post: Boolean = true,
    var can_close: Boolean = true,
    var can_open: Boolean = true
)

object WallService {
    private var posts = emptyArray<Post>()

    fun getPosts(): Array<Post> {
        return posts
    }

    fun clear() {
        posts = emptyArray()
    }

    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, fromArrPost) in posts.withIndex()) {
            if (fromArrPost.id == post.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }

}

fun main() {
//    val liked = post.copy(likes = post.likes + 1)
//    val (id, authorId, _, content) = post
//    println(post)
//    println(post.likes)
//    println(liked)
//    println("$id, $authorId, $content" + post.text)
}