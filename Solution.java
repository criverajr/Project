public class Solution
{
    public int shipWithinDays(int[] weights, int days)
    {
        int low = 0;
        int high = 0;

        for (int w : weights)
        {
            low= Math.max(low, w); // mininum capacity must be at least the heaviest single package
            high += w;  // Maximum capacity is the sum of all packages (shipped in 1 d
        }
        int result = high;
        // binary search for minimum viable capacity
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (canShip(weights, days, mid))
            {
                result = mid; // mid is a valid capacity look for a smaller one
                high = mid - 1;
            } else {
                low = mid + 1; // mid is too small, look for a larger capacity
            }
        }
        return result;
    }

    private boolean canShip(int[] weights, int days, int capacity)
    {
        int daysNeeded = 1; 
        int currentLoad = 0;

        for (int w : weights)
        {
            if (currentLoad  + w > capacity)
            {
                daysNeeded++;
                currentLoad = 0;
            }
            currentLoad += w;
        }
        return daysNeeded <= days;
    }
}