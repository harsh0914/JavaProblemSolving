  public static List<Integer> cellCompete(int[] states, int days) {

    for (int i = 0; i < days; i++) {
      List<Integer> cur = (Arrays.stream(states).boxed().collect(Collectors.toList()));
      IntStream.range(0, states.length).forEach(x -> {
        if (x == 0) {
          cur.set(x, states[x + 1]);
        } else if (x == states.length - 1) {
          cur.set(x, states[x - 1]);
        } else {
          if (states[x - 1] == states[x + 1]) {
            cur.set(x, 0);
          } else {
            cur.set(x, 1);
          }
        }
      });
      IntStream.range(0, states.length).forEach(x -> states[x] = cur.get(x));
    }
    // WRITE YOUR CODE HERE
    return Arrays.stream(states).boxed().collect(Collectors.toList());
  }

// If both cells adjacent to a cell are active or inactive it would be inactive the next day
// states[-1] and states[size+1] will always be inactive

//SampleInput
//    1 1 1 0 1 1 1 1
//SampleOutput
//    0 0 0 0 0 1 1 0
