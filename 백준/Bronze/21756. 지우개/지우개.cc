#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

void solve() {

    int n;
	std::cin >> n;

    std::vector<int> arr(n + 1);

    for (int i = 1; i <= n; i++) {
        arr[i] = i;
	}

    while (arr.size() > 2) {
        std::vector<int> evenNumbers;
        evenNumbers.push_back(0);
        for (int i = 1; i < arr.size(); i++) {
            if (i % 2 == 0) {
                evenNumbers.push_back(arr[i]);
            }
        }
		arr = evenNumbers;
    }

	std::cout << arr[1] << "\n";
	
}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}