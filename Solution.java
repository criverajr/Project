public class Solution
{
    public int shipWithinDays(int[] weights, int days)
    {
        int low = 0; // Heaviest single package
        int high = 0; // Total package array weight

        for (int w : weights)
        {
            low = Math.max(low, w); // Compares w with low, giving heaviest weight
            high += w;  // Adds running total of w as high
        }

        int result = high; // Working default

        while (low <= high) // Check possibilities until single package overtakes capacity
        {
            int mid = low + (high - low) / 2; // Start with middle capacity
            if (canShip(weights, days, mid))
            {
                result = mid; // If mid capacity is valid, try smaller
                high = mid - 1;
            } else {
                low = mid + 1; // If mid capacity is too small, try larger
            }
        }
        return result;
    }

    private boolean canShip(int[] weights, int days, int capacity)
    {
        int daysNeeded = 1; // Min days needed
        int currentLoad = 0; // Default load

        for (int w : weights)
        {
            if (currentLoad  + w > capacity) // If load is full, move to next day reset capacity
            {
                daysNeeded++;
                currentLoad = 0;
            }
            currentLoad += w; // Build current load with each package
        }
        return daysNeeded <= days; // If load works for days given, then true
    }
}