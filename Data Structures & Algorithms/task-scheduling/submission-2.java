/**

    Group the tasks into a frequency counter
    Map[taskId -> Frequency]

    We actually don't care about the id once we have the frequencies

    We want to prioritize the most recurring task ahead
    Put the frequencies in a max heap using the frequency

    variables
    maxHeap 
    coolingDown: list for jobs that just ran and can't be ran until `n` cycles
    

    time = 0
    start a loop to simulate the time passing:
    termin



    return time
*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        final var jobCounts = new HashMap<Character, Integer>();
        for (var task : tasks) {
            jobCounts.merge(task, 1, Integer::sum);
        }

        final var jobHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (var count : jobCounts.values()) {
            jobHeap.add(count);
        }

        final var jobsHolding = new ArrayList<int[]>();

        var cycles = 0;
        while (!jobHeap.isEmpty() || !jobsHolding.isEmpty()) {

            //check jobsHolding, if any jobs are eligible, put back in heap
            while (!jobsHolding.isEmpty() && jobsHolding.getFirst()[0] <= cycles) {
                jobHeap.add(jobsHolding.removeFirst()[1]);
            }

            //pop the top job of queue if exists
            if (jobHeap.isEmpty()) {
                cycles += 1;
                continue;
            }
            
            final var currentJob = jobHeap.poll();
            //if there are more jobs remaining, place remaining in holding queue,
            // to be workable at cycles + 1
            if (currentJob > 1) {
                jobsHolding.add(new int[]{cycles + n + 1, currentJob - 1});
            }


            cycles += 1;
        }




        return cycles;
    }
}
