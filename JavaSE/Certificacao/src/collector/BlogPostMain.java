package collector;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class BlogPostMain {
	public static void main(String[] args) {
		List<BlogPost> posts = Arrays.asList(new BlogPost("Como ser bonito", "Matheus", BlogPostType.GUIDE, 700),
				new BlogPost("Montar uma nave espacial", "Joao", BlogPostType.REVIEW, 2000),
				new BlogPost("Um OVNI é avistado", "Joao", BlogPostType.NEWS, 600),
				new BlogPost("Dicas de moda", "Matheus", BlogPostType.GUIDE, 500));
		
		double media = posts
				.stream()
				.collect(Collectors.averagingDouble(BlogPost::getLikes));
		

		Map<BlogPostType, List<BlogPost>> postPerType = posts.stream()
				.collect(Collectors.groupingBy(BlogPost::getType));
		
		//System.out.println(postPerType);
		
		Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor = posts.stream()
				  .collect(Collectors.groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));
		
		//System.out.println(postsPerTypeAndAuthor);
		
		Map<String, Map<BlogPostType, List<BlogPost>>> postsPerType = posts.stream()
				  .collect(Collectors.groupingBy(BlogPost::getAuthor, Collectors.groupingBy(BlogPost::getType)));

		//System.out.println(postsPerType);
		
		Map<BlogPostType, Double> averageLikesPerType = posts.stream()
				  .collect(Collectors.groupingBy(BlogPost::getType, Collectors.averagingLong(BlogPost::getLikes)));
		System.out.println(averageLikesPerType);
	}
}
