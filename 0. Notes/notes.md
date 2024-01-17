# Traversing Arrays

In Unit 4 Section 3, we discussed the concept of `String` traversal, and how we can use loops to create algorithms that systematically go through each and every character in a `String` (or sets of characters). The exact same principles can apply to arrays to make navigating through them easier, especially as they start getting larger.

---

## The Need for Array Traversal

While with small arrays it can be fairly easy to access each of the elements, this can get cumbersome very quickly. Here is an example of how we could access each and every element in an array from the `NotesNeed1.java` file:

```java
int[] ints = new int[10];
System.out.println(ints[0]);
System.out.println(ints[1]);
System.out.println(ints[2]);
System.out.println(ints[3]);
System.out.println(ints[4]);
System.out.println(ints[5]);
System.out.println(ints[6]);
System.out.println(ints[7]);
System.out.println(ints[8]);
System.out.println(ints[9]);
```

This output confirms our discussion about **default values** from Unit 6 Section 1, as it shows that all of the elements of our array have the value `0`.

Imagine using this method to print out every element of an array that had `50` values, or maybe `1,000` values. While possible, this strategy pretty quickly becomes unreasonable, and it doesn't feel much different from our initial examples in Unit 6 Section 1 where we stored data without arrays at all. This is why we need a better strategy to traverse.

---

## Array Traversal

We can officially define **array traversal** as using iteration statements to access all the elements in an array. 

Since the indices of an array start at `0` and count up, it's fairly straight-forward to develop a loop that can have its **loop control variable** go through each index. Inside the loop then, we can use the loop control variable as our index for accessing the array.

The only piece we are missing is the ability to stop before we count too high (we need to avoid `ArrayIndexOutOfBoundsException` errors). We have consistently referred to the length of an array being one of its defining characteristics, but haven't yet covered how to get that information from an array. This is one of the few times where the similarities to `String` objects ends, but is still really close. `length` is a `public` property of an array, which means you don't need an accessor method like `getLength()` (or like `length()` in the case of `String` objects). Just using the array variable (no square brackets or index required), the dot operator `.`, and `length`, you can use the length of the array to do any calculations you need. In our case, we need to use it with a relational operator like less than `<` to make sure our loop control variable doesn't count out of bounds.

Here is an example of traversal from the `NotesTraverse1.java` file:

```java
int[] ints = new int[50];
for (int i = 0; i < ints.length; i++) {
    System.out.println(ints[i]);
}
```

In Unit 4 Section 2, we introduced the idea of **off-by-one errors** when using `for` loops. This is still something we need to look out for when traversing arrays, as going too high or too low with our loop control variable (and therefore our index), can cause an `ArrayIndexOutOfBoundsException`.

We know that since we just created the `ints` array, that is has a length of `50`. This means that our loop will start counting at `0`, and as long as the current value for `i` is less than `50`, it will continue to print each element and count up. The last value that will work will be `49`, and so it prints `ints[49]`, which is the last value in the array, and then ends the loop. Just like with everything from Unit 4, anytime we do something with one type of loop, it is doable with the other, so here is another example with the same array, but now written with a `while` loop in the `NotesTraverse2.java` file:

```java
int[] ints = new int[50];
int count = 0;
while (count < ints.length) {
    System.out.println(ints[count]);
    count++;
}
```

If needed, we can also do any kind of modifications to all the elements of an array with a traversal. Here is an example of a traversal that adds 5 to every element of an array of `int` values from the `NotesTraverse3.java` file:

```java
int[] ints = new int[50];
for (int i = 0; i < ints.length; i++) {
    ints[i] += 5;
    System.out.println(ints[i]);
}
```

Finally, we aren't limited to just using our loop control variable as the index, we could use to do some other calculation dynamically. Here is an example that starts with an `int` array with all values being `0` that adds more and more to each one to make the value count from `1` to `50` at the end from the `NotesTraverse4.java` file:

```java
int[] ints = new int[50];
for (int i = 0; i < ints.length; i++) {
    ints[i] += i + 1;
    System.out.println(ints[i]);
}
```

With traversal, we can do just about anything with an array of data!

---

## Using Array Traversal

When working with large amounts of data in arrays, traversal is our primary tool to be able to effectively solve problems. In Unit 6 Section 1, when introducing the need for arrays, we introduced a problem that we haven't solved yet. The problem was calculating the average age of my given friend group. Before, it took a lot of manual writing with variable names, much like the issues we saw in the need section of these notes. Traversal makes calculations like that much easier, and more scalable.

If I want to calculate the average age of a group of people, I need to first add all of the ages up. This is the perfect application of traversal, as I need to go through each age and add them to a total. This will look a lot like our previous basic examples of array traversal, just now instead of printing each element, we will just add it to a running total. Here is what this would look like from the `NotesAverage1.java` file:

```java
int[] ages = new int[] {26, 25, 24, 26, 27, 32, 31, 26, 24, 25};
int sum = 0;
for (int i = 0; i < ages.length; i++) {
    sum += ages[i];
}
```

We make an additional variable called `sum` to keep track of the total age as we add it up. The loop starts at the first index of the array, which is always `0`, and adds the value at index `0` to the sum. It moves through each index, up to and including the last index of `9`, since the array has a length of `10`. For each of these ages, it adds them to the running total.

When calculating an average, you add up the values, and then divide it by the number of values. Now that we have added, we just need to do the division. What do we divide by? We added up `10` values through our array, so we could just code in `/ 10`, but what if we change the array later to add or remove people? Ideally, we make this calculation **dynamic**, that is, it uses available information to make sure the calculation is using the most up-to-date information. The question we should ask ourselves then, is where can we get this number that is currently `10` from our code? The answer is the length of our array, since it has `10` values currently. If we add to or take away from the array, the length would update to match, which is exactly what we want.

Here is how we would update our work from above to now properly finish calculating the average from the `NotesAverage2.java` file:

```java
int[] ages = new int[] {26, 25, 24, 26, 27, 32, 31, 26, 24, 25};
int sum = 0;
for (int i = 0; i < ages.length; i++) {
    sum += ages[i];
}
double average = (double) sum / ages.length;
System.out.println(average);
```

Notice the `(double)` cast in the average calculation to make sure it calculates as a decimal! Both our sum and length of the array are both `int` values, and so we would have gotten a truncated answer otherwise. When we run this, we get an average value of `26.6`.

Now, with just a quick modification to our ages, we can demonstrate why we set it up this way! Let's say I add two more friends, with ages `31` and `28` respectively, to the array. With how we have designed our calculation, the only thing I have to do is write those values into our array, no other modifications necessary! Here is what the changes would look like from the `NotesAverage3.java` file:

```java
int[] ages = new int[] {26, 25, 24, 26, 27, 32, 31, 26, 24, 25, 31, 28};
int sum = 0;
for (int i = 0; i < ages.length; i++) {
    sum += ages[i];
}
double average = (double) sum / ages.length;
System.out.println(average);
```

Note that the only change was in the first line, and yet the calculation properly updates! We can see that the average age has gone up to `27.083333333333332`.

---

## Assignment

Now that you have gone through the notes for this section, you can check out the `Try.md` and `Try.java` files to try a short assignment using this material.
